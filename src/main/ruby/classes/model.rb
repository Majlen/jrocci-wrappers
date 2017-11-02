require 'java'
require 'occi/infrastructure'
java_require 'classes/model'
java_package 'cz.cesnet.cloud.occi.interfaces.core'
java_import "cz.cesnet.cloud.occi.interfaces.core.Model"
java_import "cz.cesnet.cloud.occi.interfaces.core.Mixin"
java_import "cz.cesnet.cloud.occi.interfaces.core.MixinImpl"
java_import "cz.cesnet.cloud.occi.interfaces.core.Action"
java_import "cz.cesnet.cloud.occi.interfaces.core.ActionImpl"
java_import "cz.cesnet.cloud.occi.interfaces.exceptions.ParsingException"
java_import "java.util.List"

class ModelImpl
	include Model
	java_implements Model

	def initialize(model, media_type)
		if model.is_a? String
			@model = Occi::Infrastructure::Model.new

			begin
				case media_type
				when "text/plain"
					Occi::Core::Parsers::TextParser.model(model, {}, media_type, @model)
				when "application/json", "application/occi+json"
					Occi::Core::Parsers::JsonParser.model(model, {}, media_type, @model)
				end

				@model.valid! # ALWAYS validate before using the model!
			rescue Occi::Core::Errors::ParsingError => e
				raise ParsingException.new e.message
			end
		elsif model.is_a? Occi::Core::Model
			@model = model
		end
	end

	java_signature "List<Mixin> getMixins()"
	def get_mixins()
		list = java.util.LinkedList.new
		@model.mixins.each do |mixin|
			impl = MixinImpl.new(mixin)
			list.add(impl)
		end
		return list
	end

	java_signature "List<Mixin> getOsTpls()"
	def get_os_tpls()
		list = java.util.LinkedList.new
		@model.find_os_tpls.each do |mixin|
			impl = MixinImpl.new(mixin)
			list.add(impl)
		end
		return list
	end

	java_signature "List<Mixin> getResourceTpls()"
	def get_resource_tpls()
		list = java.util.LinkedList.new
		@model.find_resource_tpls.each do |mixin|
			impl = MixinImpl.new(mixin)
			list.add(impl)
		end
		return list
	end

	java_signature 'List<Action> getActions()'
	def actions()
		list = java.util.LinkedList.new
		@model.actions.each do |action|
			impl = ActionImpl.new(action)
			list.add(impl)
		end
		return list
	end
end

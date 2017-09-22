require 'java'
require 'occi/infrastructure'
java_require 'classes/model'
java_package 'cz.cesnet.cloud.occi.interfaces.core'
java_import "cz.cesnet.cloud.occi.interfaces.core.Model"
java_import "cz.cesnet.cloud.occi.interfaces.core.Mixin"
java_import "cz.cesnet.cloud.occi.interfaces.core.MixinImpl"
java_import "java.util.List"

class ModelImpl
	include Model
	java_implements Model

	def initialize(model)
		if model.is_a? String
			@model = Occi::Infrastructure::Model.new
			Occi::Core::Parsers::TextParser.model(model, {}, 'text/plain', @model)
			@model.valid! # ALWAYS validate before using the model!
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
end

Yell.new '/dev/null', name: Object
ModelImpl.new $model
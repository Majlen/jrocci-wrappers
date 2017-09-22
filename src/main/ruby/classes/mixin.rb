require 'java'
require 'occi/core'
java_require 'classes/mixin'
java_package 'cz.cesnet.cloud.occi.interfaces.core'
java_import "cz.cesnet.cloud.occi.interfaces.core.Mixin"
java_import "java.util.List"

class MixinImpl
	include Mixin
	java_implements Mixin

	def initialize(mixin)
		@mixin = mixin
	end

	java_signature 'List<Mixin> getRelations()'
	def relations()
		list = java.util.LinkedList.new
		@mixin.depends.each do |mixin|
			impl = MixinImpl.new(mixin)
			list.add(impl)
		end
		return list
	end

	java_signature 'String getTerm()'
	def term()
		return @mixin.term
	end

	java_signature 'String getTitle()'
	def title()
		return @mixin.title
	end

	java_signature 'String getSchema()'
	def schema()
		return @mixin.schema
	end
end

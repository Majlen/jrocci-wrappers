require 'java'
require 'occi/core'
java_require 'classes/action'
java_package 'cz.cesnet.cloud.occi.interfaces.core'
java_import "cz.cesnet.cloud.occi.interfaces.core.Action"

class ActionImpl
	include Action
	java_implements Action

	def initialize(action)
		@action = action
	end

	java_signature 'String getTerm()'
	def term()
		return @action.term
	end

	java_signature 'String getTitle()'
	def title()
		return @action.title
	end

	java_signature 'String getSchema()'
	def schema()
		return @action.schema
	end
end

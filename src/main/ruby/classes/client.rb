require 'java'
require 'occi/api/client'
require 'occi/core'
java_require 'client'
java_package 'cz.cesnet.cloud.occi.interfaces.api'
java_import "cz.cesnet.cloud.occi.interfaces.core.Model"
java_import "java.util.List"

class ClientImpl
	include Client
	java_implements Client

	def initialize(client)
		@client = client
	end

	java_signature 'Model getModel()'
	def model()
		return ModelImpl.new(@client.model)
	end
end


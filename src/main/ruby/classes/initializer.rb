require 'java'
require 'occi/infrastructure'
java_require 'classes/initializer'
java_package 'cz.cesnet.cloud.occi.interfaces'
java_import "cz.cesnet.cloud.occi.interfaces.Initializer"

class InitializerImpl
	include Initializer
	java_implements Initializer

	def initialize()
	end

	java_signature "void initLogger()"
	def init_logger()
		Yell.new :stderr, name: Object, level: 'gte.info'
	end
end

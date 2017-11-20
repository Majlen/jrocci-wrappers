require 'json-schema/util/uri'

module JSON
	module Util
		module URI
			def self.file_uri(uri)
				parsed_uri = parse(uri)
				if not parsed_uri.scheme.nil?
					parsed_uri
				else
					Addressable::URI.convert_path(parsed_uri.path)
				end
			end
		end
	end
end
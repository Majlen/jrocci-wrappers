require 'json-schema/schema/reader'

module JSON
	class Schema
		class Reader
			def read(location)
				uri  = JSON::Util::URI.parse(location.to_s)
				body =	if uri.scheme.nil? || uri.scheme == 'file'
							uri = JSON::Util::URI.file_uri(uri)
							read_file(Pathname.new(uri.path).expand_path)
						elsif uri.scheme == 'uri' && uri.path.start_with?("classloader:")
							read_file(Pathname.new(uri).expand_path)
						else
							read_uri(uri)
						end
				JSON::Schema.new(JSON::Validator.parse(body), uri)
			end

			def read_file(pathname)
				if accept_file?(pathname)
					if pathname.to_s.start_with?("uri:classloader:")
						File.read(pathname.to_s)
					else
						File.read(JSON::Util::URI.unescaped_path(pathname.to_s))
					end
				else
					raise JSON::Schema::ReadRefused.new(pathname.to_s, :file)
				end

				rescue Errno::ENOENT
					raise JSON::Schema::ReadFailed.new(pathname.to_s, :file)
			end
		end
	end
end
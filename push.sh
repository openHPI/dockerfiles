#!/usr/bin/env ruby
exec "docker push openhpi/#{ARGV[0].gsub('/', '')}"

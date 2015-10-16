#!/usr/bin/env ruby
exec "docker build -t openhpi/#{ARGV[0].gsub('/', '')} #{ARGV[0]}"

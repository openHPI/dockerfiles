#!/usr/bin/env ruby
exec "docker push jprberlin/#{ARGV[0].gsub('/', '')}"

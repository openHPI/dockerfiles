#!/usr/bin/env ruby
exec "docker push hklement/#{ARGV[0].gsub('/', '')}"

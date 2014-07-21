#!/usr/bin/env ruby
exec "docker build -t hklement/#{ARGV[0].gsub('/', '')} #{ARGV[0]}"

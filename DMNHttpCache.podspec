require 'json'

package = JSON.parse(File.read(File.join(__dir__, 'package.json')))

Pod::Spec.new do |s|
  s.name         = "DMNHttpCache"
  s.version      = package['version']
  s.summary      = package['description']

  s.homepage     = 'https://github.com/damoness/react-native-http-cache'
  s.license      = package['license']
  s.author       = { "Damoness" => "qjwdcool@gmail.com" }
  s.platform     = :ios, "9.0"
  s.source       = { :git => "https://github.com/damoness/react-native-http-cache.git", :tag => "master" }
  s.source_files  = "ios/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  
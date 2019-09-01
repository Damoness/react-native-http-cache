
Pod::Spec.new do |s|
  s.name         = "DMNHttpCache"
  s.version      = "1.0.0"
  s.summary      = "DMNHttpCache"
  s.description  = <<-DESC
                  DMNHttpCache
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/damoness/react-native-http-cache.git", :tag => "master" }
  s.source_files  = "ios/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  


cmake_minimum_required(VERSION 3.4.1)





#根据Android.mk引入头文件
#设置头文件查找目录
include_directories(
        src/main/cpp/lib7zr/CPP/7zip/Archive
        src/main/cpp/lib7zr/CPP/7zip/Archive/7z
        src/main/cpp/lib7zr/CPP/7zip/Archive/BZip2
        src/main/cpp/lib7zr/CPP/7zip/Archive/Common
        src/main/cpp/lib7zr/CPP/7zip/Archive/GZip
        src/main/cpp/lib7zr/CPP/7zip/Archive/Cab
        src/main/cpp/lib7zr/CPP/7zip/Archive/Lzma
        src/main/cpp/lib7zr/CPP/7zip/Archive/Tar
        src/main/cpp/lib7zr/CPP/7zip/Archive/Zip
        src/main/cpp/ lib7zr/CPP/7zip/Archive/Split
        src/main/cpp/lib7zr/CPP/7zip/Archive/Z
        src/main/cpp/lib7zr/CPP/7zip/Compress
        src/main/cpp/lib7zr/CPP/7zip/Crypto
        src/main/cpp/lib7zr/CPP/7zip/UI/Console
        src/main/cpp/lib7zr/CPP/7zip/UI/Common
        src/main/cpp/lib7zr/CPP/Windows
        src/main/cpp/lib7zr/CPP/Common
        src/main/cpp/lib7zr/CPP/7zip/Common
        src/main/cpp/lib7zr/C
        src/main/cpp/lib7zr/CPP/myWindows
        src/main/cpp/lib7zr/CPP
        src/main/cpp/lib7zr/CPP/include_windows
)

#Android 6.0以后使用这种方式，设置库查找目录
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/src/main/jniLibs/${CMAKE_ANDROID_ARCH_ABI}")
#file(GLOBAL ./../ src_path1)
#aux_source_directory(./../ src_path1)

#6.0及以后 动态库不行，静态库可以
#add_library(
#        7zr
#        SHARED
#        IMPORTED
#)
#set_target_properties()

add_library( # Sets the name of the library.
        native-lib
        SHARED
        src/main/cpp/native-lib.cpp)


target_link_libraries( # Specifies the target library.
        native-lib
        7zr
        log)
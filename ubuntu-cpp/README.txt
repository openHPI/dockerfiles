Compiler: CLang(LLVM) because of license reasons

Source einbinden:

sudo sh -c 'echo "deb http://apt.llvm.org/xenial/ llvm-toolchain-xenial-6.0 main" > pgdg.list'  //xenial durch entsprechende ubuntuversion ersetzen

wget -O - https://apt.llvm.org/llvm-snapshot.gpg.key | sodo apt-key add -

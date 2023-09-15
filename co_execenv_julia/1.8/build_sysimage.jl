#!/usr/bin/env julia

using Pkg, PackageCompiler

# Add packages to precompile
# Installing the following packages will fail on GitHub Actions (with QEMU for arm64).
# See https://github.com/JuliaLang/julia/issues/49474 and update to Julia 1.10 when it is released.
packages = [
    "Distributions",
    "LinearAlgebra",
]
Pkg.add.(packages)

# Build system image
PackageCompiler.create_sysimage(packages, sysimage_path="$(ENV["JULIA_HOME"])/lib/julia/sys.so", cpu_target="generic")

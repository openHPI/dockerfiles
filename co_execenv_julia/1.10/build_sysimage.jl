#!/usr/bin/env julia

using Pkg, PackageCompiler

# Add packages to precompile
packages = [
    "Distributions",
    "LinearAlgebra",
]
Pkg.add.(packages)

# Build system image
PackageCompiler.create_sysimage(packages, sysimage_path="$(ENV["JULIA_HOME"])/lib/julia/sys.so", cpu_target="generic")

# Dockerfiles

A collection of `Dockerfiles` for [CodeOcean](https://github.com/openHPI/codeocean).

Compatible runner managements:
- [DockerContainerPool](https://github.com/openHPI/dockercontainerpool)
- [Poseidon](https://github.com/openHPI/poseidon)

Each execution environment should be derived from docker_exec_phusion

## Content of this repository

### Supported images

- `docker_exec_phusion`: Base image for all execution environments
- `co_execenv_<langauge>`: An image used by CodeOcean for the specific programming language and version

All supported images are built for the following architectures:

- `amd64`
- `arm64`

### Deprecated images

The following images are probably not compatible with Poseidon or other runner managements. Their use is discouraged.

- `ubuntu-base`: Deprecated ubuntu base image
- `ubuntu-<language>`: Deprecated images previously used by CodeOcean

Deprecated images are only available for the `amd64` architecture.

## New or updated images

Each image derived from `docker_exec_phusion` should be compatible with a non-privileged user called `user`. Any user code will be executed as this user with the `/sbin/setuser` script provided by the base image.

### Build

```shell
docker build --no-cache -t openhpi/docker_exec_phusion docker_exec_phusion/.
docker build --no-cache -t openhpi/co_execenv_java:17 co_execenv_java/17/.
# ...
```

### Debugging

````shell
docker run -it openhpi/docker_exec_phusion bash
````

### Publishing

All images are published to [Docker Hub](https://hub.docker.com/u/openhpi) and always support the `amd64` and `arm64` architectures.

```shell
docker buildx build --platform linux/amd64,linux/arm64 --tag openhpi/docker_exec_java:17 --push co_execenv_java/17/.
```

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/openHPI/dockerfiles. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [code of conduct](https://github.com/openHPI/dockerfiles/blob/master/CODE_OF_CONDUCT.md).

## Code of Conduct

Everyone interacting in this project's codebases, issue trackers, chat rooms and mailing lists is expected to follow the [code of conduct](https://github.com/openHPI/dockerfiles/blob/master/CODE_OF_CONDUCT.md).

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

### Deprecated images

The following images are probably not compatible with Poseidon or other runner managements. Their use is discouraged.

- `ubuntu-base`: Deprecated ubuntu base image
- `ubuntu-<language>`: Deprecated images previously used by CodeOcean

## New or updated images

Each image derived from `docker_exec_phusion` should switch the user at the end of the `Dockerfile`. This ensures that users do not gain elevated privileges in their container: 

```dockerfile
USER user
```

### Build

```shell
docker build --no-cache -t openhpi/docker_exec_phusion docker_exec_phusion/.
docker build --no-cache -t openhpi/co_execenv_java:17 co_execenv_java/17/.
# ...
```

### Push

```shell
docker push openhpi/docker_exec_phusion
docker push openhpi/co_execenv_java:17
# ...
```

### Debugging

````shell
docker run -it openhpi/docker_exec_phusion bash
````

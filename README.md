docker build -f dev.Dockerfile -t banco:0.0.1 .
docker run -dp 8080:8080 --name banco banco:0.0.1
docker rm -f banco
docker logs -f banco
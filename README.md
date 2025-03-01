docker build -f dev.Dockerfile -t banco:0.0.1 .
docker run -dp 8080:8080 --name banco banco:0.0.1
docker rm -f banco
docker logs -f banco



#docker compose

docker compose up -d --build

docker compose logs -f

# Detener contenedores manteniendo datos
docker compose down

# Eliminar todo incluyendo volúmenes
docker compose down -v

# Ejecutar comando en contenedor
docker compose exec backend sh
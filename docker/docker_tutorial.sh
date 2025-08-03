#!/bin/bash

# 1. Check Docker version
echo "1. Docker Version:"
docker --version
echo

# 2. Show Docker system info
echo "2. Docker System Info:"
docker info
echo

# 3. List local Docker images
echo "3. Local Docker Images:"
docker images
echo

# 4. Pull official nginx image
echo "4. Pulling nginx image:"
docker pull nginx
echo

# 5. Create a local directory for custom web files (for volume mount)
echo "5. Creating local www directory:"
mkdir -p ./mynginx_html
echo "<h1>Hello from Docker Nginx</h1>" > ./mynginx_html/index.html
echo

# 6. Run nginx web server with port mapping and volume mount
echo "6. Running nginx web container with port and volume mapping:"
docker run -d \
  --name mywebnginx \
  -p 8080:80 \
  -v ./mynginx_html:/usr/share/nginx/html:ro \
  nginx
echo

# 7. List running containers
echo "7. Running containers:"
docker ps
echo

# 8. Access the web server (info, manual step)
echo "8. Access your web server at: http://localhost:8080/"
echo

# 9. List all containers
echo "9. All containers:"
docker ps -a
echo

# 10. Stop the 'mywebnginx' container
echo "10. Stopping 'mywebnginx' container:"
docker stop mywebnginx
echo

# 11. Start the 'mywebnginx' container
echo "11. Starting 'mywebnginx' container:"
docker start mywebnginx
echo

# 12. Show logs for 'mywebnginx'
echo "12. Logs for 'mywebnginx':"
docker logs mywebnginx
echo

# 13. Open a shell in running container (commented to avoid blocking)
# echo "13. Shell in 'mywebnginx':"
# docker exec -it mywebnginx sh
# echo

# 14. List Docker networks
echo "14. Docker networks:"
docker network ls
echo

# 15. Create new network 'mynet'
echo "15. Creating network 'mynet':"
docker network create mynet
echo

# 16. Connect 'mywebnginx' to 'mynet'
echo "16. Connect 'mywebnginx' to 'mynet':"
docker network connect mynet mywebnginx
echo

# 17. Inspect 'mywebnginx'
echo "17. Inspecting 'mywebnginx':"
docker inspect mywebnginx
echo

# 18. Commit container changes as new image
echo "18. Commit 'mywebnginx' as 'mywebnginx:v2':"
docker commit mywebnginx mywebnginx:v2
echo

# 19. Tag the new image
echo "19. Tagging 'mywebnginx:v2' as 'mywebnginx:latest':"
docker tag mywebnginx:v2 mywebnginx:latest
echo

# 20. Remove the mywebnginx:v2 image
echo "20. Removing 'mywebnginx:v2' image"
docker rmi mywebnginx:v2
echo

echo "Script completed."

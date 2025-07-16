# Stage 1: Build the Angular app
FROM node:20 AS builder

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build -- --configuration=production

# Stage 2: Serve with NGINX
FROM nginx:alpine

# Copy built app
COPY --from=builder /app/dist/my-app/browser /usr/share/nginx/html

# Copy updated nginx config
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 4200 to match your Spring Boot CORS
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
# base defines a base stage that uses the official python runtime base image
FROM python:3.12.8-slim AS base
LABEL authors="nathanielchavez"

# Add curl for healthcheck
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl && \
    rm -rf /var/lib/apt/lists/*

# things to create working dir
WORKDIR /app
ADD . /app

# Install our requirements.txt
COPY requirements.txt ./requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# dev defines a stage for development, where it'll watch for filesystem changes
FROM base AS dev
RUN pip install watchdog
ENV FLASK_ENV=development
ENV FLASK_APP=app.py
ENV FLASK_DEBUG=1

EXPOSE 5000



CMD ["python", "app.py"]

## final defines the stage that will bundle the application for production
#FROM base AS final
#
## Copy our code from the current folder to the working directory inside the container
#COPY . .
#
## Make port 80 available for links and/or publish
#EXPOSE 80
#
## Define our command to be run when launching the container
#CMD ["gunicorn", "app:app", "-b", "0.0.0.0:80", "--log-file", "-", "--access-logfile", "-", "--workers", "4", "--keep-alive", "0"]


#documentation
#https://github.com/mmumshad/simple-webapp-flask
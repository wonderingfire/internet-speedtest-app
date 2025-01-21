from flask import Flask, request, jsonify
from utils import get_download_upload, format_timestamp, get_idp, util_logger, get_current_timestamp
import uuid
import logging
import random
app = Flask(__name__)
speed_ep = '/internet_speed'
speed_ep_test = '/internet_speed_testdata'

# Configure the logger
app.logger.setLevel(logging.INFO)

@app.route('/', methods=['GET'])
def check_host():
    response = request.get("https://www.speedtest.net/speedtest-config.php")
    return jsonify({'response': response})

@app.route('/hello_world', methods=['GET'])
def hello_world():
    return "Hello world"

@app.route(speed_ep, methods=['GET'])
def get_internet_speed():
    util_logger.info(f"Triggered '{speed_ep}' endpoint")

    speed_uuid = str(uuid.uuid4())
    init_datetime = get_current_timestamp("Initialization")
    download_speed,upload_speed = get_download_upload()
    end_datetime = get_current_timestamp("Completion")

    return jsonify({'id' : speed_uuid,
                     'download_speed' : download_speed,
                     'upload_speed' : upload_speed,
                     'init_datetime' : format_timestamp(init_datetime),
                     'end_datetime' : format_timestamp(end_datetime),
                     'isp_name' : get_idp()})

@app.route(speed_ep_test, methods=['GET'])
def get_internet_speed_test():
    util_logger.info(f"Triggered '{speed_ep_test}' endpoint")

    speed_uuid = str(uuid.uuid4())
    init_datetime = get_current_timestamp("Initialization")
    end_datetime = get_current_timestamp("Completion")

    return jsonify({'id' : speed_uuid,
                     'download_speed' : round(float(random.randint(100,300)), 2),
                     'upload_speed' : round(float(random.randint(100,250)), 2),
                     'init_datetime' : format_timestamp(init_datetime),
                     'end_datetime' : format_timestamp(end_datetime),
                     'isp_name' : "Test_IDP"})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)

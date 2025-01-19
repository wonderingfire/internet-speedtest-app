from datetime import datetime
import speedtest
import logging

util_logger = logging.getLogger("app.py")

def get_download_upload():
    st = speedtest.Speedtest()
    download_speed = round(st.download() / (1024 * 1024), 2)
    log_message(f"Download Speed: {download_speed} Mbps")
    upload_speed = round(st.upload() / (1024 * 1024), 2)
    util_logger.info(f"Upload Speed: {upload_speed} Mbps")
    return download_speed, upload_speed

def get_idp():
    idp = speedtest.Speedtest().get_config()["client"]["isp"]
    log_message(f"IDP: {idp} ")
    return idp

def format_timestamp(timestamp):
    return timestamp.strftime("%b %d, %Y %I:%M:%S %p")

def log_message(message):
    util_logger.info(message)

def get_current_timestamp(time_type):
    init_datetime = datetime.now()
    log_message(f"{time_type} Time: {format_timestamp(init_datetime)}")
    return init_datetime
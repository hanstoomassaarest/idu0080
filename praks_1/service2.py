
from flask import Flask
import requests
# pip install requests

app = Flask(__name__)

@app.route("/", methods=['GET', 'OPTIONS'])
def get_all_via_service_1():
    return requests.get('http://127.0.0.1:5000/programs').text

if __name__ == '__main__':
    port = 8000 #the custom port you want
    app.run(host='127.0.0.3', port=port)
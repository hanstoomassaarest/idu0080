from flask import Flask, jsonify

app = Flask(__name__, static_url_path='')

@app.route('/programmeerimiskeeled', methods = ['GET', 'POST', 'OPTIONS'])
def home():
    return app.send_static_file('home.html')

if __name__ == '__main__':
    port = 8000 #the custom port you want
    app.run(host='127.0.0.1', port=8080)
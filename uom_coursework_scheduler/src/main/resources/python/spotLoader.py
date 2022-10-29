import urllib.request
import requests
from lxml import etree

class Login(object):
	def __init__(self):
		self.login_headers = {
			"User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36", 
			"Host": "login.manchester.ac.uk"
		}
		self.action_headers = {
			"Referer": "https://login.manchester.ac.uk/cas/login?service=https%3A%2F%2Fstudentnet.cs.manchester.ac.uk%2Fme%2Fspotv2%2Fspotv2.php",
			"User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36",
			"Host": "login.manchester.ac.uk"
		}
		self.logined_headers = {
			"Referer": "https://login.manchester.ac.uk/",
			"User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36", 
			"Host": "studentnet.cs.manchester.ac.uk"
		}
		self.login_url = "https://login.manchester.ac.uk/cas/login?service=https%3A%2F%2Fstudentnet.cs.manchester.ac.uk%2Fme%2Fspotv2%2Fspotv2.php"
		self.logined_url = "https://studentnet.cs.manchester.ac.uk/me/spotv2/spotv2.php"
		self.session = requests.Session()
	
	def getToken(self):
		respond = self.session.get(self.login_url, headers=self.login_headers)
		selector = etree.HTML(respond.text)
		self.token = selector.xpath('//section[5]/input/@value')

	def login(self):
		post_data = {
			"submit": "Login",
			"_eventId": "submit",
			"lt": self.token[0],
			"execution": self.token[1],
			"username": "y02478jh",
			"password": "Hjy20011222."
		}
		respond = self.session.post(self.login_url, data=post_data, headers=self.action_headers, allow_redirects=False)
		respond = self.session.get(respond.headers.get("Location"), headers=self.logined_headers)
		respond = self.session.get(self.logined_url, headers=self.logined_headers)
		print(respond.text)
if __name__ == "__main__":
	login = Login()
	login.getToken()
	login.login()

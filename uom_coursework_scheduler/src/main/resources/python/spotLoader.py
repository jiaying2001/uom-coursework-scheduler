import urllib.request
import requests
from lxml import etree
from pyquery import PyQuery as pq

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
		self.getToken()
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

		courseUnits = ["SUM-2022COMP26120", "SUM-2022COMP26020", "SUM-2022COMP24011", "SUM-2022COMP23311", "SUM-2022COMP21111", "SUM-2022COMP22111"]
		doc = pq(respond.text)
		for courseUnit in courseUnits:
			dueAssessments = doc("#" + courseUnit + " td")
			self.convert_to_JSON(dueAssessments.text())
	
	def convert_to_JSON(self, string):
		string = string.replace("&nbsp ", "").replace("Tag", "").replace("🤞", "submitted ").replace("🟢", "").replace("🟠", "").split()
		Json_string = ''
		for i in range(0, int(len(string) / 8)):
			Json_string += '{{"Assessment Name": "{}", "Weight": "{}", "Due": "{}", "Marks": "{}" }},'.format(string[0 + i * 8], string[1 + i * 8], "-".join(string[2 + i * 8 : 6 + i * 8]), " ".join(string[6 + i * 8 : 8 + i * 8]))
		Json_string = '[' + Json_string[0 : len(Json_string) - 1] + ']'
		print(Json_string)
if __name__ == "__main__":
	login = Login()
	login.login()


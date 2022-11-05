import urllib.request
import requests
from lxml import etree

class Login(object):
	def __init__(self):
		self.userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36"
		self.render_headers = {
			"User-Agent": self.userAgent, 
			"Host": "my.manchester.ac.uk"
		}
		self.login_headers = {
			"User-Agent": self.userAgent, 
			"Host": "login.manchester.ac.uk"
		}
		self.redirect_headers = {
			"User-Agent": self.userAgent, 
			"Host": "my.manchester.ac.uk",
			"Referer": "https://login.manchester.ac.uk/",
		}
		self.action_headers = {
			"Referer": "https://login.manchester.ac.uk/cas/login?service=https%3A%2F%2Fstudentnet.cs.manchester.ac.uk%2Fme%2Fspotv2%2Fspotv2.php",
			"User-Agent": self.userAgent,
			"Host": "login.manchester.ac.uk"
		}
		self.access_headers = {
			"Referer": "https://my.manchester.ac.uk/uPortal/f/home/p/timetable.u23l1n3101/max/render.uP",
			"User-Agent": self.userAgent,
			"Host": "my.manchester.ac.uk"
		}
		self.session = requests.Session()
		self.login_url = "https://login.manchester.ac.uk/cas/login?service=https://my.manchester.ac.uk/uPortal/Login%3FrefUrl%3D%2FuPortal%2Ff%2Fhome%2Fp%2Ftimetable.u23l1n3101%2Fmax%2Frender.uP"
		self.timetable_url = "https://my.manchester.ac.uk/uPortal/f/home/p/timetable.u23l1n3101/max/weekViewJson.resource.uP?pP_personId=10729326&weekNumber=7&academicYear=2022_23"
		self.render_url = "https://my.manchester.ac.uk/uPortal/f/home/p/timetable.u23l1n3101/max/render.uP"
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
		# 登入
		respond = self.session.post(self.login_url, data=post_data, headers=self.action_headers, allow_redirects=False)
		# 跳转 
		redirect = respond.headers["Location"]
		respond = self.session.get(redirect, headers=self.redirect_headers, allow_redirects=False)
		redirect = respond.headers["Location"]
		respond = self.session.get(redirect, headers=self.redirect_headers, allow_redirects=False)
	def render(self):
		respond = self.session.get(self.render_url, headers=self.render_headers, allow_redirects=False)
	def getTimetable(self):
		respond = self.session.get(self.timetable_url, headers=self.access_headers)
		print(respond.text)
	def main(self):
		self.render()
		self.render()
		self.getToken()
		self.login()
		self.render()
		self.getTimetable()
if __name__ == "__main__":
	login = Login()
	login.main()

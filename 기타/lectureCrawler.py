from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from PIL import Image as Image  # Rename Image from PIL to avoid conflict

driver = webdriver.Chrome(executable_path="./chromedriver.exe")
url = "https://edu.ssafy.com/comm/login/SecurityLogoutForm.do"
driver.get(url)

# 로그인 정보
username = "jsh001505@naver.com"
password = "tjgml^^7"

# 로그인 페이지로 이동
login_url = (
    "https://edu.ssafy.com/comm/login/SecurityLoginForm.do"  # 로그인 페이지 주소로 대체해야 합니다.
)
driver.get(login_url)

# 아이디와 비밀번호 입력
username_input = driver.find_element("name", "userId")  # 아이디 입력 필드의 name 속성으로 찾기
password_input = driver.find_element("name", "userPwd")  # 비밀번호 입력 필드의 name 속성으로 찾기
username_input.send_keys(username)
password_input.send_keys(password)

# 로그인 버튼 클릭
login_button = driver.find_element(
    "xpath", "/html/body/div[1]/div/div/div[2]/form/div/div[2]/div[3]/a"
)  # 로그인 버튼의 텍스트로 찾기
login_button.click()

# 로그인 후 몇 초간 대기 (페이지가 로딩되는 시간을 고려)
time.sleep(1)
# 브라우저 창 최대화
driver.maximize_window()
time.sleep(3)
# 이미지 다운로드 반복
base_img_url = "https://edu.ssafy.com/data/upload_files/crossUpload/openLrn/ebook/unzip/A2023090718301399800/assets/page-images/page-30f0010c-5be8e15c-"
start_page = 1
last_page = 37
lecture_name = "데이터검색, DML"

# 이미지를 추가할 리스트 생성
elements = []
firstImage = None

for i in range(start_page, last_page + 1):
    img_url = f"{base_img_url}{i:04d}.jpg"
    driver.get(img_url)
    driver.save_screenshot(f"{lecture_name}_{i:02d}.png")
    img = Image.open(f"{lecture_name}_{i:02d}.png")

    # 이미지 크기 확인
    width, height = img.size

    # 이미지 좌우에서 110px씩 자르기
    left_cut = 110
    right_cut = width - 110
    cropped_img = img.crop((left_cut, 0, right_cut, height))
    cropped_img = cropped_img.convert("RGB")
    # 잘린 이미지 저장
    # cropped_img.save(f"{lecture_name}_{i:02d}.png")

    if i == start_page:
        firstImage = cropped_img
    else:
        elements.append(cropped_img)
firstImage.save(f"{lecture_name}.pdf", save_all=True, append_images=elements)

# 브라우저 닫기
driver.quit()

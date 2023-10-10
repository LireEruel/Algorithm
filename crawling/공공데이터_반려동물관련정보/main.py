import requests
import json

content_info_file_path = "crawling\공공데이터_반려동물관련정보\contentInfo.json"
result_file_path = "crawling\공공데이터_반려동물관련정보\placeInfo.json"
url = "http://apis.data.go.kr/B551011/KorService1/detailPetTour1"  # 요청을 보낼 URL

try:
    with open(content_info_file_path, "r", encoding="utf-8") as content_info_file:
        data = json.load(content_info_file)
    with open(result_file_path, "r", encoding="utf-8") as result_file:
        result_data = json.load(result_file)
    content_index = data["content_index"]
    service_key_index = data["service_key_index"]
    service_key_list = data["service_key_list"]
    content_id_list = data["content_id_list"]

    print("JSON 파일을 성공적으로 읽었습니다.")
    while True:
        service_key = service_key_list[service_key_index]
        content_id = content_id_list[content_index]

        params = {
            "serviceKey": service_key,
            "contentId": content_id,
            "pageNo": 1,
            "numOfRows": 10,
            "MobileOS": "ETC",
            "MobileApp": "AppTest",
            "_type": "json",
        }  # 추가할 파라미터

        print("params : " + str(params))
        req_url = (
            url
            + "?serviceKey="
            + params["serviceKey"]
            + "&contentId="
            + str(params["contentId"])
            + "&pageNo="
            + str(params["pageNo"])
            + "&numOfRows="
            + str(params["numOfRows"])
            + "&MobileOS="
            + params["MobileOS"]
            + "&MobileApp="
            + params["MobileApp"]
            + "&_type="
            + params["_type"]
        )

        try:
            response = requests.get(req_url, verify=False)  # GET 요청에 파라미터 추가
            response.raise_for_status()  # 요청이 성공했는지 확인
            data = response.json()
            data = data["response"]["body"]

            # 응답 내용 출력

            if data["numOfRows"] > 0:
                result_data["place_list"].append(data["items"]["item"][0])
                with open(result_file_path, "w", encoding="utf-8") as result_file:
                    json.dump(result_data, result_file, indent=4, ensure_ascii=False)
                    print(result_data)
            else:
                print(data)
        except requests.exceptions.RequestException as e:
            print(f"request 오류 발생: {e}")

        finally:
            content_index += 1

except Exception as e:
    print(f"오류 발생: {e}")

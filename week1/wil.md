웹의 소통방식 HTTP와 REST API
=============
1.웹이란?
-------

- 정의 
    - 인터넷 : 컴퓨터와 기기를 연결하는 거대 네트워크
    - 웹 : 인터넷 위에서 작동하는 서비스 중 하나
- 클라이언트 서버 모델
    - 클라이언트 : request를 보내고 서버의 응답결과를 받아 처리
    - 서버 : 클라이언트의 요청을 받고 response를 반환

### URL
요청할때 주소가 필요함   
웹 상에서 특정 자원의 위치를 나타내는 주소 Uniform Resource Locator
- Host : 리소스가 위치하는 서버 ip
- Port : 서버의 특정 포트번호
- Path : 서버 내 원하는 리소스 경로
- Query : 서버에 추가적인 정보를 보내는 파라미터

2.HTTP
----
요청할때 통신규약      

- Http(HyperText Transper Protocol)
    - 서버 - 클라이언트 모델의 프로토콜
- 특징
    - 무상태성 : 서버는 클라이언트의 이전 요청을 저장하지 않는다 
    - 비연결성 : 클라이언트가 요청을 보내고 응답받은 후 서버와 연결을 유지하지않음
### HTTP 요청 구조
- Start line : 요청 메서드, 요청경로
- headers : 요청에 대한 부가정보
- body : 실제 전송할 데이터

### HTTP 주요 메서드
- GET : 리소스를 조회
- POST : 리소스를 추가, 등록
- PUT : 리소스를 교체, 없으면 새로 생성
- PATCH : 리소스의 일부를 수정
- DELETE : 리소스를 삭제

### HTTP 주요 상태 코드
- 200 OK
- 201 Created : 요청이 성공적 처리, 새로운 리소스 생성
- 400 Bad Request : 클라이언트의 요청이 잘못됨 서버가 이해x
- 404 Not Found : 지정한 리소스를 찾을 수 없음
- 500 Internal Server Error : 서버 내부 오류로 요청 처리 불가

3.API와 REST API
-----
http로만 내용을 전달하기엔 어려움이 있다   

### API (Application Programming Interface)
     한 프로그램이 다른 프로그램의 기능이나 데이터를 사용할 수 있도록 미리 정해둔 약속

어떻게 요청하고 응답할지 규칙과 기능을 정리해둔 목록 

### REST (Representational State Transfer)
     REST는 네트워크 아키텍처 스타일로 HTTP의 장점을 최대한 활용 할 수 있는 아키텍쳐
- REST 구성 요소
    - 자원 - URI : 모든 자원은 고유한 ID를 가지며 이ID는 /student/1와 같은 http uri이다.
    - 행위(Verb) - Method : 자원을 조작하기 위해 사용함
    - 표현 : 서버와 클라이언트가 데이터를 주고 받는 형식 json이 일반적

결론 : REST는 HTTP를 잘 활용하기 위한 원칙
REST API는 이 원칙을 준수해 만든 API이자 HTTP의 모범사례


4.API 명세서 작성하기
--------------------

### 상품 기능

    1. 상품 정보 등록   
    HTTP Method : POST   
    URI : /products   

    2. 상품 목록 조회
    HTTP Method : GET   
    URI : /products

    3. 개별 상품 정보 상세 조회
    HTTP Method : GET   
    URI : /products/{productId}    

    4. 상품 정보 수정
    HTTP Method : GET   
    URI : /products/{productId}          

    5. 상품 삭제
    HTTP Method : GET   
    URI : /products/{productId}          

### 주문 기능
    1. 주문 정보 생성   
    HTTP Method : POST   
    URI : /order   

    2. 주문 목록 조회
    HTTP Method : GET   
    URI : /order

    3. 개별 주문 정보 상세 조회
    HTTP Method : GET   
    URI : /order/{orderId}    
     
    4. 주문 취소    
    HTTP Method : GET   
    URI : /order/{orderId}     

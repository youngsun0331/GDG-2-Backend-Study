계층형 아키텍처와 컨트롤러, 서비스

1.Spring의 핵심설계 : 계층형 아키텍쳐
----------

### 스프링 계층형 아키텍처(Layered Architecture)
Browser -> Controller -> Service -> DAO/Repository -> DB   
손님 -> 웨이터 -> 주방장 -> 창고 관리인 -> 냉동창고   

- DTO = 주문서,영수증
    - 데이터 전송 객체(Data Transfer Object)

- Entity = 원재료
    - DB 테이블과 맵핑되는 객체
    - 외부 직접 노출 금지


2.웹 요청의 진입점 : 컨트롤러 계층
-----
## Controller
URL을 통해 Browser에서 먼저 요청 받는 계층 json 형태로 요청/반환

## 계층형 vs 도메인형
파일저장 방법은 두가지로 나뉨

- 계층형 구조
    - 애플케이션을 기능별로 나눈다
    - Controller 파일 , Service 파일 ...

- 도메인형 구조
    - 애플리케이션을 도메인별로 나눈다
    - 특정 도메인의 코드를 한곳에 모아둠 



3.스프링 빈 & 의존성 주입 - 압축ver
----

```java
@Contoroller
@ResponseBody
->
@RestController

```
컨트롤러 표시
http 반환값


4.비즈니스 로직의 중심 : 서비스 계층
----



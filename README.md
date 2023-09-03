## 스프링 부트 게시판 무작정 따라하기
[유튜브 강의](https://www.youtube.com/watch?v=frI5CoZe-vE&list=PLZzruF3-_clsWF2aULPsUPomgolJ-idGJ)

1. Entity  
데이터베이스에 쓰일 필드와 여러 엔티티간 연관관계를 정의한다.  
@Entity - 이 클래스가 엔티티임을 알려줌. JPA에서 정의된 필드들을 바탕으로 데이터베이스에 테이블을 만들어준다.   

2. Repository  
Entity에 의해 생성된 DB에 접근하는 메소드들을 사용하기 위한 인터페이스   
JpaRepository를 상속받으면 기본적인 동작들이 가능해짐.   
JpaRepository<대상으로 지정할 엔티티, 해당 엔티티의 PK의 타입>  

3. JPA  
JPA가 제공하는 API를 사용하면 객체를 DB에 저장하고 관리할 때, 개발자가 직접 SQL을 작성하지 않아도 된다.  

4. 스프링의 Thymeleaf란  
'템플릿 엔진'의 일종. html 태그에 속성을 추가해 페이지에 동적으로 값을 추가하거나 처리할 수 있다.  

* * *
#### 실습  
[controller]  
 - @GeMappin(), @PostMapping() 안에 /board/write와 같은 url 필요  
 - 매개변수로 받는것을 DB에 저장하기위해 repository,entity 필요   
 - html에서 name으로 지정한것이 controller 매개변수로 넘어옴  
 - model.addAttribute 에 값을 넣어서 return할때 같이 넘김  
 - return "redirect:/" 를 통해 해당 url로 감  
 - @PathVariable("id") Integer id -> url에서 가져온 id값을 매개변수로 사용할 때  

[entity]  
 - DB 테이블을 의미함  
 - JPA가 Entity를 읽어들임  
 - 기본키를 자동으로 생성할 때에는 @Id와 @GeneratedValue 어노테이션이 함께 사용되어야 한다.  
 - @Data 로 getter, setter, toString, equals 등을 할수있다.   
 
[repository]  
 - 인터페이스 생성된  
 - JpaRepository를 상속받음  
 
[service]  
 - @Autowired 통해서 알아서 주입  
 - Service는 Controller 에서 이용  
 - Service 에서 boardRepository 사용  
 
[html]  
 - a태그 href="@{/url}" : 서버내 특정위치로 이동  

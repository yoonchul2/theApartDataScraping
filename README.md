코틀린 프로젝트 


기본 문법 

-----------------------------------------------------

1. 자바와 차이점 

자바 : 라인이 끝날때 ;(세미콜론 필수)

코틀린 : 필요없음 


-----------------------------------------------------

2. 기본 변수 선언 

자바 : String str

코틀린 : val str : String

모든 변수는 두가지 타입으로 정의

val = 값을 변경할수 없는 변수(자바의 final)

var = 값을 변경할수 있는 변수

ex ) var str = "테스트" 

따로 변수 타입을 지정안해줘도 set한 값의 타입을 자동으로 인식해줌

-----------------------------------------------------

3. getter / setter


자바 : 변수의 값을 할당시키거나 가져올때 

form.getName()/
form.setName("test") 

필요

코틀린 

get :
var name = form.name 

set :
form.name = "방국봉"

바로 꺼내오거나 바로 할당가능

-----------------------------------------------------

4. 변수 생성시 초기화 

자바 : 

String str = new String()

기본 변수를 생성하고 아무값도 할당하지않아도됨 

코틀린 : 

var str : String --> X

반드시 기본값을 할당해줘야함 

var str : String = "" --> O

예외로 lateinit var str : String 을쓴다면

나중에 초기화 시킬수있음

-----------------------------------------------------
5. 인자의 기본값 할당

자바 : 

private String test(String str,Integer Idx){
return str
}

호출 : test("test") ---> X

--> 함수에 선언되있다면 
idx를 반드시 아무값이든 할당해서 보내야함

코틀린 

fun test(str : String,Idx : Integer? =null) : String{

return str
}

호출 : test(str) -> str만 보내서 호출가능

Idx : Integer? =null 전달받는 인자값에 기본값또는 null 할당가능

-----------------------------------------------------

6. 코틀린의 null 처리

? : null이 될수있는 타입의 변수

!! : NULL이 될 수 있는 타입의 변수이지만, 현재 NULL이 아님을 주장할 수 있다.


ex ) foo?.bar() 
?가 붙었으므로 null일경우 bar을 무시하고 null을 반환
null이 아닐경우 bar()함수 정상적으로 실행후 리턴

fun foo(s: String?) {
val t: String = s ?: ""
}
이런식으로 응용가능


-----------------------------------------------------

7. 함수 생성

자바 :

private String test(){

return str
}

모든 함수는 fun으로 생성
private fun test() : String{
return str
}
-----------------------------------------------------

8. return 조건 생략

fun maxf2(a: Int, b: Int) = if(a > b) a else b

따로 return을 명시하지않아도 위방식처럼 사용가능

-----------------------------------------------------

9. 콘솔 출력

자바 : System.out.println()

코틀린 println()


-----------------------------------------------------
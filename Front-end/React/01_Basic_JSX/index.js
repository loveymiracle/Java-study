import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// React (리액트)란?
// - facebook에서 만든 js 라이브러리(프레임워크)로 SPA를 구축하기 위해 사용된다.
// - 전통적인 웹은 page별로 구분 되며 Layout을 기반으고 구역 설계를 수행하였다면,
// - SPA는 컴포넌트 중심으로 설계되며 하나의 페이지에서 교체되는 방향으로 설계를 수행한다.
// - react는 전통적인 웹 구성보다 더 복잡한 설계 구조를 가지고 있지만, 당연 장점을 보유한다.
// - 장점 : 트래픽이 적어지고, 반응성이 올라간다. 컴포넌트 구성으로 재사용성이 높아진다. 
//          백엔드 코드와 Layer 분리가 된다. -> MSA 설계가 가능해진다. ★★★★★
// - 단점 : 아키텍처가 복잡해진다. 코드가 오히려 어려워진다. (클라이언트 PC에 부담을 준다.-> 부담 X)
//          당장은 front 엔지니어가 필요하여 개발비가 상승한다. -> 하지만, 향후에는 이득이 될수있다. 


// JSX(Javascript Syntax eXtension)란?
// - Javascript에 확장한 문법으로 js에서 html 작성 표현하기 까다로움으로
//   html 형식으로 쉽게 표현하기 위해 생겨난 문법이다. 
// - 실제 코드 실행 시에는 jsx를 js로 다시 해석 하고 순수 js만 변환되어 실행된다.
//  -> 이유는 jsx 자체는 브라우저에서 통용되는 문법이 아님으로 이를 번역하여 js로 사용된다.

// element(엘리먼트)란?
// - React element는 JSX에서 html 태그 문장이 표현 된 불변 객체(const)이다.
// - element를 생성한 이후에는 해당 element의 자식이나 속성(props)을 변경할 수 없습니다.
// - element는 영화에서 하나의 프레임과 같이 특정 시점의 UI를 보여줍니다.
// - element는 불변 객체지만, 미리 정해놓은 state 따라 선언 될 때 변경될수 있다.

// 이곳이 jsx 세상! -> js의 확장된 문법이 먹히는 구간!

// root - div를 찾아와서 ReactDOM(Virtual dom)을 생성하는 과정
// ReactDOM을 통해서만 react 객체를 사용할수 있다!
const root = ReactDOM.createRoot(document.getElementById('root'));

// 0. javascript 문법 확ㅣㄴ
// let value = 0;
// alert(value);
// for(let i = 0; i < 10; i++) {
  // alert(i);
// }

// 1. 가장 기본적인 엘리먼트를 작성하는 방법
// const element = <h1>Hello Reacrt World!!</h1> // element는 일반적으로 const로 작성하는 것이 기본
const element = (<h1>Hello React World!!</h1>)
root.render(element);

// 2. jsx 표현식을 통해 인자를 넣는 방법
const name = '홍길동';
// const element1 = <h1>Hello, {name}님 안녕하세요?</h1>; // {..} : 표현식으로 js 인자를 넣을 수 있다.
// const element1 = (<App, {name}님 안녕하세요?);
const element1 = (<h1>{`Hello, ${name}님 안녕하세요?`}</h1>); // {` `} : 백틱 문법 사용 가능, ${..}

root.render(element1);

// 3. jsx 함수 사용 및 다중 태그 element 구성
const member = {
  name:'홍길동',
  age:27,
  address:'서울시 강남구 역삼동',
}
const member2 = {
  name:'최길동',
  age:28,
  address:'서울시 강남구 역삼동',
}

// 여기서 반환 되는 인자는 element = HTMLUListElement
// element는 다중 태그를 사용할 수 있으나 반드시 단일 태그로 감싸야 활용 가능! = 병렬 안된다!
function formatMember(member) {
  return <ul>
            <li>이름 : {member.name}</li>
            <li>나이 : {member.age}</li>
            <li>주소 : {member.address}</li>
        </ul>;
}

const element2 = (
  <div>
    <h3>사용자 정보</h3>
    {formatMember(member)}
    {formatMember(member2)}
  </div>
);

root.render(element2);

// 4. 함수내에서 if문이나 삼항연산자 활용하는 방법
const member3 = {
  name:'박길동',
  age:32,
  address:'서울시 강남구 삼성동',
  phone: '010-1234-5678'
}
const member4 = {
  name:'',
  age:19,
  address:'서울시 강남구 역삼동',
}

// if문 적용
function getMemberElement(member) {
  if(member.name != null && member.name.length !== 0) {
    return <ul>
            <li>이름 : {member.name}</li>
          </ul>;
  } else {
    return <ul>
            <li>이름 : 이름이 비었습니다.</li>
          </ul>;
  }
}
root.render(getMemberElement(member4));

function checkValue(str) {
  if(str != null && str.length !== 0) {
    return str;
  } else {
    return '비었습니다.';
  }
}

// 삼항연산자 활용
function getMemberElement2(member) {
  return <ul>
          <li>이름 : {member.name != null && member.name.length !== 0 ? member.name:'비었습니다.'} </li>
          <li>나이 : {checkValue(member.age)}</li>
          <li>주소 : {checkValue(member.address)}</li>
          <li>전번 : {checkValue(member.phone)}</li>
        </ul>;
}

root.render(getMemberElement2(member4));

// 5. jsx를 통해 태그 속성을 정의하는 방법
// -> ""을 지우고 js 변수를 표현식으로 사용하면 된다.

const siteInfo1 = {
  name :'구글',
  url :'http://www.google.com',
  imageUrl : 'https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png',
}

const siteInfo2 = {
  name :'네이버',
  url :'http://www.naver.com',
  imageUrl : 'https://s.pstatic.net/static/www/mobile/edit/20230504/mobile_111836114478.png',
}

function siteInfo(siteInfo) {
  return (
    <div>
      <h3>{siteInfo.name}</h3>
      <a href={siteInfo.url}>{siteInfo.name}로 이동</a>
      <img src={siteInfo.imageUrl} alt={`${siteInfo.name}의 이미지입니다.`} />
    </div>
  );
}

root.render(<div>
  {siteInfo(siteInfo1)}
  <hr /><br />
  {siteInfo(siteInfo2)}
</div>);

// 6. css 적용하는 방법
const style = {
  color:'#61DBFB',
  background:'black',
  fontSize: '80px', 
  fontWeight :'bold'
};

const element6 = (
  <div style={style}>
    Hello React World!
  </div>
)

root.render(element6);

// 7. css를 class로 적용하기
const className = 'testClass';
const element7 = (
  <div className={className}>
    Hello React World!
  </div>
);

root.render(element7);

// 8. 순수 javascript로 수동으로 element 생성하기
const element8 = React.createElement(
  'h3',
  {className:'testClass'},
  'Hello React World',
);

root.render(element8);

// 9. 시간에 따른 업데이트가 되는 element 
function tick() {
  const element9 = (
    <div>
      <h1>Hello, world!</h1>
      <h2>It is {new Date().toLocaleTimeString()}.</h2>
    </div>
  );
  root.render(element9);
}

setInterval(tick, 1000);


// 문법 에러를 잡아주는 문장 -> 건들지 않는다.
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

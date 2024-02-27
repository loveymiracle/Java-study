import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import './components/my_css.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import MyComponent1 from './components/MyComponent1';
import MyComponent2 from './components/MyComponent2';
import MyComponent3 from './components/MyComponent3';

// props : 태그의 속성과 비슷하게 React Component로 초기 인자를 넣어주는 불변의 값=생성자 파라미터

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<div>
              <MyComponent1 name="홍길동" age="27" address="서울시 강남구 역삼동"/>
              <hr/><br/>
              <MyComponent2 name="박길동" age="21" address="서울시 강남구 역삼동" phone="010-1234-5678" />
              <hr/><br/>
              <MyComponent3 name="홍길동" age="27" address="서울시 강남구 역삼동"/>
              <hr/><br/>
            </div>);






// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

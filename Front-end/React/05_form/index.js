import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import MyForm1 from './components/MyForm1';
import MyForm2 from './components/MyForm2';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
      <MyForm1 inputName="박길동" inputAge="36"/>
      <hr />
      <MyForm2 nameValue="박길동" textValue="자기소개 텍스트"  selectValue="C++" checkMail= "true" />
  </div>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

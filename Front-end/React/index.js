import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import IterationSample1 from './components/IterationSample1';
import IterationSample2 from './components/IterationSample2';
import IterationSample3 from './components/IterationSample3';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <IterationSample3/>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

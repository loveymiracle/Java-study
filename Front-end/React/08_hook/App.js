import logo from './logo.svg';
import './App.css';
import Counter1 from './components/Counter1';
import Counter2 from './components/Counter2';
import Info1 from './components/Info1.js';
import Info2 from './components/Info2.js';
import UsePromiseSample from './components/UsePromiseSample';
import Average from './components/Average.js/index.js';

function App() {
  return (
    <div className="App">
      <Counter1 />
      {<Counter2 />}
      <Info1 />
      <Info2 />
      <UsePromiseSample />
      <Average />
    </div>
  );
}

export default App;

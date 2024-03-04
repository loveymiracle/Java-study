import React, { Component } from 'react';
import ScrollBox from './components/ScrollBox';
import ValidationSample from './components/ValidationSample';

// Ref를 활용하는 곳 : 포커스, 스크롤 등의 몇개 이벤트만 고유하게 필요함
class App extends Component {
  render() {
    return (
      <div>
        <ValidationSample/>
        <br/>
        <ValidationSample/>
        <br/>
        <ScrollBox ref={ref => (this.scrollBox = ref)} />
        <button onClick={() => this.scrollBox.scrollToBottom()}>
          맨 밑으로
        </button>
      </div>
    );
  }
}
export default App;

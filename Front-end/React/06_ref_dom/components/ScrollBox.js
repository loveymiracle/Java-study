import React, { Component } from 'react';

// https://ko.legacy.reactjs.org/docs/forwarding-refs.html

// 외부에서 ID를 주입하는 방법
class ScrollBox extends Component {
  scrollToBottom = () => {
    const { scrollHeight, clientHeight } = this.box;
    /* 앞 코드에는 비구조화 할당 문법을 사용했습니다.
    다음 코드와 같은 의미입니다.
    const scrollHeight = this.box.scrollHeight;
    const clientHeight = this.box.cliengHeight;
    */
    this.box.scrollTop = scrollHeight - clientHeight;
  };

  render() {
    const style = {
      border: '1px solid black',
      height: '300px',
      width: '300px',
      overflow: 'auto',
      position: 'relative'
    };
    const innerStyle = {
      width: '100%',
      height: '650px',
      background: 'linear-gradient(white, black)'
    };
    return (
      <div
        style={style}
        // ref : Virtual DOM에서 사용되는 가상 아이디로 해당 element를 Virtual DOM에서 참조할때 사용됨
        ref={ref => {
          this.box = ref;
        }}
      >
        <div style={innerStyle} />
      </div>
    );
  }
}
export default ScrollBox;

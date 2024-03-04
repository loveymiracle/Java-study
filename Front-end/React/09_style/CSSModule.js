import React from 'react';
import classNames from 'classnames/bind';
import styles from './CSSModule.module.scss';

// CSS Module 사용 예제
// 리액트 프로젝트에서 컴포넌트를 스타일링 할 때 CSS Module을 사용하면
// CSS 클래스가 중첩되는 것을 완벽히 방지할 수 있다.

const cx = classNames.bind(styles); // 미리 styles 에서 클래스를 받아오도록 설정

const CSSModule = () => {
  return (
    <div className={cx('wrapper', 'inverted')}>
      안녕하세요, 저는 <span className="something">CSS Module!</span>
    </div>
  );
};

export default CSSModule;

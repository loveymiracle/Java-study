import React from 'react';
import { useParams, Link } from 'react-router-dom';
import Categories from './Categories';
import NewsList from './NewsList';

const NewsPage = ({ match }) => {
  const params = useParams();
  // 카테고리가 선택되지 않았으면 기본값 all로 사용
  const category = params.category || 'all';

  return (
    <>
      <Link to="/basic">기본 예제1</Link><br />
      <Link to="/basic2">기본 예제2</Link>
      <Categories />
      <NewsList category={category} />
    </>
  );
};

export default NewsPage;

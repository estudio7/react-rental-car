import React from 'react';
import ProductItem from './ProductItem';

class ProductList extends React.Component {
  render() {
    const { products } = this.props;
    return (
      <div className="product-list">
        {products.map(product => (
          <ProductItem key={product.id} product={product} />
        ))}
      </div>
    );
  }
}

export default ProductList;

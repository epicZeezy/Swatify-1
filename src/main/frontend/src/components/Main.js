import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';
import Feed from './Feed';
import Discover from './Discover';
import Discuss from './Discuss';
import Connect from './Connect';
import Users from './Users';
import Artists from './Artists';
import Album from './Album';
import SearchPage from './SearchPage';

export default class Main extends Component {
  render() {
    return (
      <Switch>
        <Route exact from='/' to='/feed' />
        <Route path='/feed' component={Feed} />
        <Route path='/discover' component={Discover} />
        <Route path='/discuss' component={Discuss} />
        <Route path='/connect' component={Connect} />
        <Route path='/users' component={Users} />
        <Route path='/artists' component={Artists} />
        <Route path='/album' component={Album} />
        <Route path='/search' component={SearchPage} />
      </Switch>
    );
  }
}

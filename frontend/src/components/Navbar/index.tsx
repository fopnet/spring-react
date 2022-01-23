import { ReactComponent as GitHubIcon } from 'assets/img/github.svg';
import './styles.css';

function NavBar() {

    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>Movie Store</h1>
                    <a href="https://github.com/fopnet/spring-react">
                        <div className="dsmovie-nav-contact">
                            <GitHubIcon />
                            <p>/fopnet</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default NavBar;
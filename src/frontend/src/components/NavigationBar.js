import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

export const NavigationBar = () => {
    return (
        <Navbar data-bs-theme="dark" expand="lg" className="bg-body-tertiary" style={{ marginBottom: '40px', borderRadius: '5px'}}>
            <Container fluid>
                <Navbar.Brand href="/">NBA Information Board</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        {/*TODO: replace with actual links*/}
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/calendar">Games</Nav.Link>
                        <Nav.Link href="/players">Players</Nav.Link>
                        <NavDropdown title="Link" id="navbarScrollingDropdown">
                            <NavDropdown.Item href="#action4">
                                Misc.
                            </NavDropdown.Item>
                            <NavDropdown.Item href="#action5">
                                About
                            </NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                    <Form className="d-flex">
                        <Form.Control
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}
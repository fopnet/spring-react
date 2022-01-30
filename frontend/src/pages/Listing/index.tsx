import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/Movie";
import { BASE_URL } from "utils/requests";


function Listing() {

    const [pageNumber, setPageNumber] = useState(0);

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=12&page=0`).then(resp => {
            const movieDate = resp.data as MoviePage;
            setPageNumber(movieDate.number);
        });
    }, []);


    return (
        <div >
            <Pagination />
            <div className="container" >
                <div className="row" >
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3" >
                        <MovieCard />
                    </div>                 
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3" >
                        <MovieCard />
                    </div>             
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3" >
                        <MovieCard />
                    </div>                
                    
                </div>
            </div>

        </div>
    );
}


export default Listing;
package by.controller;

import by.model.Workers;
import by.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class MyController {

    private WorkerService workerService;

    @Autowired(required = true)
    @Qualifier(value = "Service")
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public ModelAndView main(){
        List<Workers> list = workerService.listWorker();

        return new ModelAndView("workers", "list", list);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("workers") Workers workers) {
        if (workers.getId() == 0) {
            workerService.saveWorker(workers);
        } else {
            workerService.updateWorker(workers);
        }
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        workerService.deleteWorker(id);
        List<Workers> list = workerService.listWorker();
        return new ModelAndView("workers", "list", list);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id){
       // model.addAttribute()
        Workers workers = workerService.getById(id);
        return new ModelAndView("workersEditor", "workers", workers);
    }

}

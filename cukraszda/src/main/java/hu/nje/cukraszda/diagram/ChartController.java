package hu.nje.cukraszda.diagram;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChartController {

    private final ArRepository arRepository;

    public ChartController(ArRepository arRepository) {
        this.arRepository = arRepository;
    }

    @GetMapping("/diagram")
    public String showDiagram(Model model) {

        List<Object[]> data = arRepository.findChartData();

        List<Integer> labels = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for (Object[] row : data) {
            labels.add((Integer) row[0]);   // sutiid
            values.add((Integer) row[1]);   // ertek
        }

        model.addAttribute("labels", labels);
        model.addAttribute("values", values);

        return "diagram";
    }
}